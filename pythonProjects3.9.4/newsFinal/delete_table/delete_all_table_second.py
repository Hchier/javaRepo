import sqlite3

con = sqlite3.connect('../test_second.db')
c = con.cursor()

#
c.execute("delete from educationtable")
c.execute("delete from financetable")
c.execute("delete from gametable")
c.execute("delete from militarytable")

c.execute("delete from realestatetable")
c.execute("delete from showbiztable")
c.execute("delete from technologytable")
c.execute("delete from cartable")
# #
c.execute("delete from petable")

# cursor = c.execute("select * from educationtable")
# print("cursor:", cursor)
# for row in cursor:
#     print(row[0], row[1])

con.commit()
con.close()