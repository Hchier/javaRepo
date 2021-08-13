import xlrd
import jieba.posseg
import sqlite3
from nltk.cluster.util import cosine_distance
# import numpy

con = sqlite3.connect('../test.db')
c = con.cursor()
file1 = open('../game1.txt', 'r', encoding = 'UTF-8')

check = {'财经': 0, '房产': 0, '教育': 0, '科技': 0, '军事': 0,
         '汽车': 0, '体育': 0, '游戏': 0, '娱乐': 0, }
proportion_avg = []

car_judge_count = [0] * 300
car_proportion = []
sheet_name = '汽车'
book = xlrd.open_workbook("../test_data.xlsx")
sheet = book.sheet_by_name(sheet_name)
for i_total in range(0, 20):
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



for i in range(0, 300):
    car_select_sql = "select * from cartable where seq='" + str(i) + "'"
    # print(car_select_sql)
    cursor = c.execute(car_select_sql)
    # print("cursor:", cursor)
    for row in cursor:
        car_proportion.append(row[1])

# for i_seq in range(0, 300):
#     if car_seq[i_seq] != 0:
#         print(i_seq, car_seq[i_seq])
#         print(i_seq, car_proportion[i_seq])

print(car_judge_count)
print(car_proportion)
print(cosine_distance(car_judge_count, car_proportion))
