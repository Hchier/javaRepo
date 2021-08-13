import xlrd
import xlwt
import jieba.posseg
from collections import Counter
import  sqlite3

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()
keyword = []
weight = []
for i in range(0, 300):
    select_sql = "select * from temptable where seq='" + str(i) + "'"
    print(select_sql)
    cursor = c.execute(select_sql)
    temp_weight = 0
    for row in cursor:
        keyword.append(row[0])
        weight.append(row[1])

excle = xlwt.Workbook(encoding = "utf-8")
sheet1 = excle.add_sheet("999", cell_overwrite_ok = True)


for i in range(0, 300):
    sheet1.write(i, 0, keyword[i])
    sheet1.write(i, 1, weight[i])
excle.save("../temp.xls")




# import xlrd
# import xlwt
# import jieba.posseg
# from collections import Counter
# import  sqlite3
#
# con = sqlite3.connect('../lib_origin.db')
# c = con.cursor()
# keyword = []
# weight = []
# for i in range(0, 1):
#     select_sql = "select * from temptable"
#     print(select_sql)
#     cursor = c.execute(select_sql)
#     temp_weight = 0
#     for row in cursor:
#         print(row[0])
#         print(row[1])
#         print("1111111111111111111111111111111111111111111111111111111111111111111111111")




