import xlrd
import xlwt
import jieba.posseg
import sqlite3
from collections import Counter

con = sqlite3.connect('../test.db')
c = con.cursor()
file1 = open('../game1.txt', 'r', encoding = 'UTF-8')

check = {'财经': 0, '房产': 0, '教育': 0, '科技': 0, '军事': 0,
         '汽车': 0, '体育': 0, '游戏': 0, '娱乐': 0, }
proportion_avg = []

sheet_name = '财经'
book = xlrd.open_workbook("../test_data.xlsx")
sheet = book.sheet_by_name(sheet_name)
for i_total in range(0, 8598):
    str9 = sheet.cell_value(rowx = i_total, colx = 0)

    items = []
    items_all = jieba.posseg.cut(str9)

    for item in items_all:
        if (item.flag == 'n' or item.flag == 'v' or
            item.flag == 'nr' or item.flag == 'ns' or
            item.flag == 'nt' or
            item.flag == 'nz' or item.flag == 'vg' or item.flag == 'vn') \
                and len(item.word) > 1:
            items.append(item.word)

    weight = {}
    game_weight = 0
    finance_weight = 0
    realestate_weight = 0
    education_weight = 0
    technology_weight = 0
    military_weight = 0
    car_weight = 0
    PE_weight = 0
    showbiz_weight = 0
    if items:
        for item in items:
            game_select_sql = "select * from gametable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(game_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                game_weight += row[1]
        print("game_weight:", game_weight)
        weight.update({game_weight: '游戏'})

        for item in items:
            finance_select_sql = "select * from financetable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(finance_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                finance_weight += row[1]
        print("finance_weight:", finance_weight)
        weight.update({finance_weight: '财经'})

        for item in items:
            realestate_select_sql = "select * from realestatetable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(realestate_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                realestate_weight += row[1]
        print("realestate_weight:", realestate_weight)
        weight.update({realestate_weight: '房产'})

        for item in items:
            education_select_sql = "select * from educationtable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(education_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                education_weight += row[1]
        print("education_weight:", education_weight)
        weight.update({education_weight: '教育'})

        for item in items:
            technology_select_sql = "select * from technologytable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(technology_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                technology_weight += row[1]
        print("technology_weight:", technology_weight)
        weight.update({technology_weight: '科技'})

        for item in items:
            military_select_sql = "select * from militarytable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(military_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                military_weight += row[1]
        print("military_weight:", military_weight)
        weight.update({military_weight: '军事'})

        for item in items:
            car_select_sql = "select * from cartable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(car_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                car_weight += row[1]
        print("car_weight:", car_weight)
        weight.update({car_weight: '汽车'})

        for item in items:
            pe_select_sql = "select * from petable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(pe_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                PE_weight += row[1]
        print("pe_weight:", PE_weight)
        weight.update({PE_weight: '体育'})

        for item in items:
            showbiz_select_sql = "select * from showbiztable where keyword='" + item + "'"
            # print(select_sql)
            cursor = c.execute(showbiz_select_sql)
            # print("cursor:", cursor)
            for row in cursor:
                # print(row[0])
                showbiz_weight += row[1]
        print("showbiz_weight:", showbiz_weight)
        weight.update({showbiz_weight: '娱乐'})

        print()
        weight_total = 0
        max_weight = 0
        list1 = list(weight.keys())
        for item_weight in list1:
            weight_total += item_weight

        max_weight = max(weight.keys())
        max_weight_proportion = max_weight / weight_total
        proportion_avg.append(max_weight_proportion)
        proportion_single = str(max_weight_proportion * 100) + "%"
        print("proportion_single:", proportion_single)
        proportion_avg_total = 0
        for i_proportion_avg in range(0, len(proportion_avg)):
            proportion_avg_total += proportion_avg[i_proportion_avg]
        print("proportion_avg:", proportion_avg_total / len(proportion_avg))

        check[weight[max_weight]] += 1

        print("第", i_total)
        print(check)
        print(check[sheet_name] / (i_total))
        print("极大可能为:", weight[max_weight], '类新闻\n')
        i_total += 1
####################################################################


check_total_num = 0
check_values_list = list(check.values())
check_keys_list = list(check.keys())
for item in check_values_list:
    check_total_num += item

i = 0
for item in check_keys_list:
    check[item] = check_values_list[i] / check_total_num * 100
    print(item, ",", check[item], ",", check_values_list[i])
    i += 1
