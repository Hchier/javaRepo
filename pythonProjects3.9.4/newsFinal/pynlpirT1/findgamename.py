import xlrd
import xlwt
import jieba.posseg
from collections import Counter
import re

# book = xlrd.open_workbook("../test_data.xlsx")
# sheet = book.sheet_by_name('体育')
# str = ''
# for i in range(0, 601):
#     str = str + sheet.cell_value(rowx = i, colx = 0)
#
#
#     # if item.flag == 'n' and len(item.word) > 1:
#
#     # if (item.flag == 'n' or
#     #     item.flag == 'nr' or item.flag == 'ns' or
#     #     item.flag == 'nt' or
#     #     item.flag == 'nz' or item.flag == 'vn') \
#     #         and len(item.word) > 1:
open
# file1 = open('../game1.txt', 'r', encoding = 'UTF-8')
book = xlrd.open_workbook("../test_data.xlsx")
sheet = book.sheet_by_name('游戏')
str1 = []
findTitle = re.compile(r'<span class="title">(.*)</span>')
find_game_name = re.compile(r'.*?《(.*)》.*?')
for i in range(0, 13):
    str = sheet.cell_value(rowx = i, colx = 2)
    str1.append(re.compile(find_game_name, str))
for name in str1:
    print(name)


