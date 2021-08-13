import xlrd
# import xlwt
import jieba.posseg
import sqlite3
# from collections import Counter
# from nltk.cluster.util import cosine_distance
# import numpy
# from TEST import second_compare


def get_G_values_proportion(dict):
    value_list = list(dict.values())
    sum = 0
    for value in value_list:
        sum += value
    proportion = max(value_list) / sum
    return proportion

def get_table_name(name):
    if name == '汽车':
        return "cartable"
    elif name == '教育':
        return "educationtable"
    elif name == '财经':
        return "financetable"
    elif name == '游戏':
        return "gametable"
    elif name == '军事':
        return "militarytable"
    elif name == '体育':
        return "petable"
    elif name == '房产':
        return "realestatetable"
    elif name == '娱乐':
        return "showbiztable"
    elif name == '科技':
        return "technologytable"


def second_compare_def(words, name):
    con = sqlite3.connect('../test_second.db')
    c = con.cursor()
    second_weight = 0
    for word in words:
        print(word)
        select_sql = "select * from " + get_table_name(name) + " where keyword='" + word + "'"
        # print(select_sql)
        cursor = c.execute(select_sql)
        # print("cursor:", cursor)
        for row in cursor:
            print(row[0])
            second_weight += row[1]

    return second_weight


def get_ave_dict_values(dict):
    sum = 0
    value_list = list(dict.values())
    keys_list = list(dict.keys())
    for i in range(0, len(keys_list)):
        print(keys_list[i], value_list[i])
    for value in value_list:
        sum += value
    if len(value_list) == 0:
        return 0
    else:
        result = (sum / len(value_list))
        return result


def print_dict(dict):
    value_list = list(dict.values())
    keys_list = list(dict.keys())
    for i in range(0, len(keys_list)):
        print(keys_list[i], value_list[i])


# def second_compare():


con = sqlite3.connect('../lib_origin.db')
c = con.cursor()
file1 = open('../game1.txt', 'r', encoding = 'UTF-8')

check = {'财经': 0, '房产': 0, '教育': 0, '科技': 0, '军事': 0,
         '汽车': 0, '体育': 0, '游戏': 0, '娱乐': 0, }
check_second = {'财经': 0, '房产': 0, '教育': 0, '科技': 0, '军事': 0,
                '汽车': 0, '体育': 0, '游戏': 0, '娱乐': 0, }
check_vector = {'财经': 0, '房产': 0, '教育': 0, '科技': 0, '军事': 0,
                '汽车': 0, '体育': 0, '游戏': 0, '娱乐': 0, }
proportion_avg = []

sheet_name = '教育'
book = xlrd.open_workbook("../test_data.xlsx")
sheet = book.sheet_by_name(sheet_name)
st_nd_yes = {}
st_nd_no = {}
for i_total in range(0, 501):
    str9 = sheet.cell_value(rowx = i_total, colx = 0)

    items = []
    items_all = jieba.posseg.cut(str9)

    for item in items_all:
        # if (item.flag == 'n' or item.flag == 'v' or
        #     item.flag == 'nr' or item.flag == 'ns' or
        #     item.flag == 'nt' or
        #     item.flag == 'nz' or item.flag == 'vg' or item.flag == 'vn') \
        #         and len(item.word) > 1:
        if (item.flag == 'n' or
            item.flag == 'nr' or item.flag == 'ns' or
            item.flag == 'nt' or
            item.flag == 'nz') \
                and len(item.word) > 1:
            items.append(item.word)

    weight = {}
    vector_dict = {}

    game_weight = 0
    finance_weight = 0
    realestate_weight = 0
    education_weight = 0
    technology_weight = 0
    military_weight = 0
    car_weight = 0
    PE_weight = 0
    showbiz_weight = 0

    car_judge_count = [0] * 300
    car_proportion = []
    game_judge_count = [0] * 300
    game_proportion = []
    finance_judge_count = [0] * 300
    finance_proportion = []
    realestate_judge_count = [0] * 300
    realestate_proportion = []
    education_judge_count = [0] * 300
    education_proportion = []
    technology_judge_count = [0] * 300
    technology_proportion = []
    military_judge_count = [0] * 300
    military_proportion = []
    PE_judge_count = [0] * 300
    PE_proportion = []
    showbiz_judge_count = [0] * 300
    showbiz_proportion = []

    row0game = {}
    if items:
        for item in items:
            game_select_sql = "select * from gametable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(game_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                game_weight += row[1]

                game_judge_count[row[2]] += 1

        print("game_weight:", game_weight)
        weight.update({game_weight: '游戏'})

        # for i in range(0, 300):
        #     game_select_sql = "select * from gametable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(game_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         game_proportion.append(row[1])
        # vector_dict.update({cosine_distance(game_judge_count, game_proportion): '游戏'})

        for item in items:
            finance_select_sql = "select * from financetable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(finance_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                finance_weight += row[1]
                finance_judge_count[row[2]] += 1
        print("finance_weight:", finance_weight)
        weight.update({finance_weight: '财经'})

        # for i in range(0, 300):
        #     finance_select_sql = "select * from financetable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(finance_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         finance_proportion.append(row[1])
        # vector_dict.update({cosine_distance(finance_judge_count, finance_proportion): '财经'})

        for item in items:
            realestate_select_sql = "select * from realestatetable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(realestate_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                realestate_weight += row[1]
                if '房' in item:
                    realestate_weight += 1
                realestate_judge_count[row[2]] += 1
                row0game.update({row[0]: row[1]})
        print("realestate_weight:", realestate_weight)
        weight.update({realestate_weight: '房产'})

        # for i in range(0, 300):
        #     realestate_select_sql = "select * from realestatetable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(realestate_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         realestate_proportion.append(row[1])
        # vector_dict.update({cosine_distance(realestate_judge_count, realestate_proportion): '房产'})

        for item in items:
            education_select_sql = "select * from educationtable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(education_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                education_weight += row[1]
                education_judge_count[row[2]] += 1
        print("education_weight:", education_weight)
        weight.update({education_weight: '教育'})

        # for i in range(0, 300):
        #     education_select_sql = "select * from educationtable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(education_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         education_proportion.append(row[1])
        # vector_dict.update({cosine_distance(education_judge_count, education_proportion): '教育'})

        for item in items:
            technology_select_sql = "select * from technologytable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(technology_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                technology_weight += row[1]
                technology_judge_count[row[2]] += 1
        print("technology_weight:", technology_weight)
        weight.update({technology_weight: '科技'})

        # for i in range(0, 300):
        #     technology_select_sql = "select * from technologytable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(technology_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         technology_proportion.append(row[1])
        # vector_dict.update({cosine_distance(technology_judge_count, technology_proportion): '科技'})

        for item in items:
            military_select_sql = "select * from militarytable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(military_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                military_weight += row[1]
                military_judge_count[row[2]] += 1
        print("military_weight:", military_weight)
        weight.update({military_weight: '军事'})

        # for i in range(0, 300):
        #     military_select_sql = "select * from militarytable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(military_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         military_proportion.append(row[1])
        # vector_dict.update({cosine_distance(military_judge_count, military_proportion): '军事'})

        for item in items:
            car_select_sql = "select * from cartable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(car_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                car_weight += row[1]
                car_judge_count[row[2]] += 1

        print("car_weight:", car_weight)
        weight.update({car_weight: '汽车'})

        # for i in range(0, 300):
        #     car_select_sql = "select * from cartable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(car_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         car_proportion.append(row[1])
        # vector_dict.update({cosine_distance(car_judge_count, car_proportion): '汽车'})

        for item in items:
            pe_select_sql = "select * from petable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(pe_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                PE_weight += row[1]
                PE_judge_count[row[2]] += 1
        print("pe_weight:", PE_weight)
        weight.update({PE_weight: '体育'})

        # for i in range(0, 300):
        #     pe_select_sql = "select * from petable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(pe_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         PE_proportion.append(row[1])
        # # print(PE_judge_count)
        # # print(PE_proportion)
        # vector_dict.update({cosine_distance(PE_judge_count, PE_proportion): '体育'})

        for item in items:
            showbiz_select_sql = "select * from showbiztable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(showbiz_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                showbiz_weight += row[1]
                showbiz_judge_count[row[2]] += 1
        print("showbiz_weight:", showbiz_weight)
        weight.update({showbiz_weight: '娱乐'})

        # for i in range(0, 300):
        #     showbiz_select_sql = "select * from showbiztable where seq='" + str(i) + "'"
        #     # print(car_select_sql)
        #     cursor = c.execute(showbiz_select_sql)
        #     # print("cursor:", cursor)
        #     for row in cursor:
        #         showbiz_proportion.append(row[1])
        # vector_dict.update({cosine_distance(showbiz_judge_count, showbiz_proportion): '娱乐'})
        # print()

        # 向量
        # vector_dict_values_list = list(vector_dict.values())
        # vector_dict_keys_list = list(vector_dict.keys())
        # print("第", i_total)
        # print(vector_dict)
        # class_vector = vector_dict[min(vector_dict_keys_list)]
        # check_vector[class_vector] += 1
        # print(check_vector)
        #
        # print("(vector)极大可能为:", class_vector, '类新闻\n')

        # 权重
        print()
        weight_total = 0
        max_weight = 0
        # 权重列表
        list1 = list(weight.keys())
        # 获得第二权重
        list1_copy = list1
        list1_copy.remove(max(weight.keys()))
        second_weight = max(list1_copy)
        for item_weight in list1:
            weight_total += item_weight

        # 在weight字典里找最大权重，输出其对应的新闻种类
        max_weight = max(weight.keys())
        # 最大权重在weight字典里的占比
        max_weight_proportion = max_weight / weight_total
        # 在多条新闻中，平均最大权重占比
        proportion_avg.append(max_weight_proportion)
        proportion_single = str(max_weight_proportion * 100) + "%"
        print("proportion_single:", proportion_single)
        proportion_avg_total = 0
        for i_proportion_avg in range(0, len(proportion_avg)):
            proportion_avg_total += proportion_avg[i_proportion_avg]
        print("proportion_avg:", proportion_avg_total / len(proportion_avg))

        # 判断出的种类数量+1
        check[weight[max_weight]] += 1

        print("第", i_total)
        print("check")
        print(check)
        max_w_s = max_weight / second_weight
        print("max_weight/second:", max_w_s)
        flag1 = 0
        flag2 = 0
        final = ''
        if max_w_s < 1.5:
            print("max_w_s")
            flag1 = max_weight + second_compare_def(items, weight[max_weight])
            flag2 = second_weight + second_compare_def(items, weight[second_weight])
            print("m_s", max_weight, second_weight)
            print("f1_2", flag1, flag2)
            if flag1 > flag2:
                print("(weight)可能为:", weight[max_weight], '类新闻\n')
                final = weight[max_weight]
                check_second[weight[max_weight]] += 1
            else:
                print("(weight)可能为:", weight[second_weight], '类新闻\n')
                check_second[weight[second_weight]] += 1
                final = weight[second_weight]
        else:
            print("(weight)可能为:", weight[max_weight], '类新闻\n')
            check_second[weight[max_weight]] += 1
            final = weight[max_weight]
        print("check_second")
        print(check_second)
        if final != sheet_name:
            # st_nd_no.update({i_total: weight[max_weight]})
            st_nd_no.update({i_total: max_w_s})
        else:
            # st_nd_yes.update({i_total: weight[max_weight]})
            st_nd_yes.update({i_total: max_w_s})
        i_total += 1
####################################################################


check_total_num = 0
# 判断出的各个种类对应的数量
check_values_list = list(check.values())
check_keys_list = list(check.keys())
for item in check_values_list:
    check_total_num += item

print("yes")
# for item in st_nd_yes:
#     print(st_nd_yes)
print(get_ave_dict_values(st_nd_yes))
print("no")
# for item in st_nd_no:
#     print(item)
print(get_ave_dict_values(st_nd_no))
i = 0
for item in check_keys_list:
    check[item] = check_values_list[i] / check_total_num * 100
    print(item, ",", check[item], ",", check_values_list[i])
    i += 1
print(check_second)
print(get_G_values_proportion(check_second))
# print()
# print(print_dict(row0game))
