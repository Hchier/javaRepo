import xlrd
import sqlite3

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()

book = xlrd.open_workbook("../lib20.xlsx")
sheet = book.sheet_by_name('汽车6')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    # str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"')"
    str1 = str("insert into cartable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('教育3')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into educationtable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('财经1')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into financetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('game8')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into gametable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('军事5')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into militarytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('体育7')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into petable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('房产2')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into realestatetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('娱乐9')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into showbiztable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('科技4')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"

    print(str1)
    c.execute(str1)


con.commit()
con.close()