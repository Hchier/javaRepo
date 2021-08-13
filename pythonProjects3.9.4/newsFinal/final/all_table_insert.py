import xlrd
import sqlite3

con = sqlite3.connect('lib_origin.db')
c = con.cursor()

book = xlrd.open_workbook("lib30.xlsx")
sheet = book.sheet_by_name('汽车')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    # str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"')"
    str1 = str("insert into cartable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('教育')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into educationtable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('财经')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into financetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('游戏')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into gametable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('军事')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into militarytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('体育')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into petable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('房产')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into realestatetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('娱乐')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into showbiztable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('科技')
for i in range(0, 300):
    keyword = sheet.cell_value(rowx = i, colx = 3)
    weight = float(sheet.cell_value(rowx = i, colx = 5))
    str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"

    print(str1)
    c.execute(str1)


con.commit()
con.close()