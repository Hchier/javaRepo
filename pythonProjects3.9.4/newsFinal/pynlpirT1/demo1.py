import xlrd
import xlwt
import jieba.posseg
import sqlite3
from collections import Counter

con = sqlite3.connect('test.db')
c = con.cursor()
file1 = open('../game1.txt', 'r', encoding = 'UTF-8')
# print(file1.read())
items = []
items_all = jieba.posseg.cut(file1.read())
for item in items_all:
    if (item.flag == 'n' or item.flag == 'v' or
        item.flag == 'nr' or item.flag == 'ns' or
        item.flag == 'nt' or
        item.flag == 'nz' or item.flag == 'vg' or item.flag == 'vn') \
            and len(item.word) > 1:
        items.append(item.word)


weight1 = 0
weight2 = 0
for item in items:
    select_sql = "select * from gametable where keyword='"+item+"'"
    # print(select_sql)
    cursor = c.execute(select_sql)
    # print("cursor:", cursor)
    for row in cursor:
        # print(row[0])
        weight1 += row[1]
print("weight1:", weight1)


# for item in items:
#     select_sql = "select * from financetable where keyword='" + item + "'"
#     # print(select_sql)
#     cursor = c.execute(select_sql)
#     # print("cursor:", cursor)
#     for row in cursor:
#         # print(row[0])
#         weight2 += row[1]
# print("weight2:", weight2)
