import xlrd
import sqlite3

con = sqlite3.connect('../test_second.db')
c = con.cursor()

book = xlrd.open_workbook("../lib20.xlsx")

sheet = book.sheet_by_name('汽车6')
for i in range(0, 50):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    # str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"')"
    str1 = str("insert into cartable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('教育3')
for i in range(0, 49):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into educationtable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('财经1')
for i in range(0, 50):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into financetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('game8')
for i in range(0, 53):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into gametable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('军事5')
for i in range(0, 54):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into militarytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('体育7')
for i in range(0, 60):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into petable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('房产2')
for i in range(0, 24):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into realestatetable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('娱乐9')
for i in range(0, 50):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into showbiztable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"
    print(str1)
    c.execute(str1)

sheet = book.sheet_by_name('科技4')
for i in range(0, 50):
    keyword = sheet.cell_value(rowx = i, colx = 15)
    weight = float(sheet.cell_value(rowx = i, colx = 16))
    str1 = str("insert into technologytable values('")+keyword+"','"+str(weight)+"','"+str(i)+"')"

    print(str1)
    c.execute(str1)


con.commit()
con.close()