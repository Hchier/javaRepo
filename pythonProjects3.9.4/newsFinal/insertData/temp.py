import xlrd
import sqlite3

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()

book = xlrd.open_workbook("../lib20.xlsx")
sheet = book.sheet_by_name('财经1')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 4))
    str1 = str("insert into temptable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"

    print(str1)
    c.execute(str1)

# c.execute('''CREATE TABLE gametable
#        (keyword CHAR(10) PRIMARY KEY NOT NULL,
#        weight real not null
#        );''')

con.commit()
con.close()
