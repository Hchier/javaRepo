import sqlite3
import xlrd
import xlwt

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()
excle1 = xlwt.Workbook(encoding = "utf-8")
sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)

total_weight1 = 0
total_weight2 = 0
count = 0
for i in range(0, 300):
    word1 = ''
    word2 = '0'
    word3 = '0'
    weight1 = 0
    weight2 = 0
    weight3 = 0
    sql1 = "select * from financetable where seq='" + str(i) + "'"
    cursor = c.execute(sql1)
    for row in cursor:
        word1 = row[0]
        weight1 = row[1]

    sql2 = "select * from technologytable where keyword='" + word1 + "'"
    # print(sql2)
    cursor = c.execute(sql2)
    for row in cursor:
        word2 = row[0]
        weight2 = row[1]

    sql3 = "select * from realestatetable where keyword='" + word1 + "'"
    # print(sql2)
    cursor = c.execute(sql3)
    for row in cursor:
        word3 = row[0]
        weight3 = row[1]

    if word2 == '0':
        mult1 = 2
    else:
        print("/:", weight1 / weight2)
        mult1 = weight1 / weight2
        if mult1 > 2:
            mult1 = 2
        if mult1 < 0.5:
            mult1 = 0.5
        print("mult1:", mult1)
    if word3 == '0':
        mult2 = 2
    else:
        print("/:", weight1 / weight3)
        mult2 = weight1 / weight3
        if mult2 > 2:
            mult2 = 2
        if mult2 < 0.5:
            mult2 = 0.5
        print("mult2:", mult2)
    mult = mult1 * mult2


    if mult < 3.9:
        delete_sql1 = "delete  from temptable where keyword='" + word1 + "'"
        # print(select_sql1)
        cursor1 = c.execute(delete_sql1)
    else:
        print("multi", mult)
        select_sql1 = "select * from temptable where keyword='" + word1 + "'"
        # print(select_sql1)
        cursor1 = c.execute(select_sql1)
        temp_weight = 0
        for row1 in cursor1:
            print(row1[1])
            temp_weight = mult * float(row1[1])

        update_sql1 = "update temptable set weight = " + str(temp_weight) + " where keyword ='" + word1 + "'"
        update_sql2 = "update  temptable set seq = " + str(count) + " where keyword ='" + word1 + "'"
        print("update_sql:", update_sql1)
        cursor = c.execute(update_sql1)
        print("update_sq2:", update_sql2)
        cursor = c.execute(update_sql2)
        con.commit()
        count += 1

print("count:", count)
print(total_weight1, total_weight2)
con.close()
