import sqlite3
import xlrd
import xlwt


con = sqlite3.connect('../lib_origin.db')
c = con.cursor()
excle1 = xlwt.Workbook(encoding = "utf-8")
sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)

total_weight1 = 0
total_weight2 = 0
for i in range(0, 300):
    word1 = ''
    word2 = '0'
    word3 = '0'
    weight1 = 0
    weight2 = 0
    weight3 = 0
    sql1 = "select * from technologytable where seq='" + str(i) + "'"
    cursor = c.execute(sql1)
    for row in cursor:
        word1 = row[0]
        weight1 = row[1]

    sql2 = "select * from financetable where keyword='" + word1 + "'"
    # print(sql2)
    cursor = c.execute(sql2)
    for row in cursor:
        word2 = row[0]
        weight2 = row[1]

    if word2 != '0':
        print(word2)
        total_weight1 += weight1
        total_weight2 += weight2
        # print(word1)
        # print(weight1, weight2)

print(total_weight1, total_weight2)
con.close()
