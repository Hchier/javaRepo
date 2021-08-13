import sqlite3

con = sqlite3.connect('../test.db')
c = con.cursor()

for i in range(0, 300):
    proportion = [0] * 9
    word = ''

    sql1 = "select * from technologytable where seq='" + str(i) + "'"
    cursor = c.execute(sql1)
    for row in cursor:
        word = row[0]
        # print("word:", word)
        proportion[0] = row[1]

    sql2 = "select * from realestatetable where keyword='" + word + "'"
    cursor = c.execute(sql2)
    for row in cursor:
        proportion[1] = row[1]

    sql3 = "select * from educationtable where keyword='" + word + "'"
    cursor = c.execute(sql3)
    for row in cursor:
        proportion[2] = row[1]

    sql4 = "select * from financetable where keyword='" + word + "'"
    cursor = c.execute(sql4)
    for row in cursor:
        proportion[3] = row[1]

    sql5 = "select * from militarytable where keyword='" + word + "'"
    cursor = c.execute(sql5)
    for row in cursor:
        proportion[4] = row[1]

    sql6 = "select * from cartable where keyword='" + word + "'"
    cursor = c.execute(sql6)
    for row in cursor:
        proportion[5] = row[1]

    sql7 = "select * from petable where keyword='" + word + "'"
    cursor = c.execute(sql7)
    for row in cursor:
        proportion[6] = row[1]

    sql8 = "select * from gametable where keyword='" + word + "'"
    cursor = c.execute(sql8)
    for row in cursor:
        proportion[7] = row[1]

    sql9 = "select * from showbiztable where keyword='" + word + "'"
    cursor = c.execute(sql9)
    for row in cursor:
        proportion[8] = row[1]

    sum = 0
    # for item in proportion:
    #     print(item)
    #
    for i_get_sum in range(1, 9):
        sum += proportion[i_get_sum]
    # print("ave:", sum / 8)
    if proportion[0] < sum / 8:
        print(i)
        print("word", word)
        print("proportion[0]", proportion[0])
        print("ave:", sum / 8)

# book = xlrd.open_workbook("../test_data.xlsx")
# for i in range(2, 10):
#     sheet = book.sheet_by_name('娱乐')
#     sheet.cell_value(rowx = i, colx = 0)
