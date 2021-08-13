import sqlite3

con = sqlite3.connect('../test.db')
c = con.cursor()

c.execute("drop table cartable")
c.execute("drop table educationtable")
c.execute("drop table financetable")
c.execute("drop table gametable")
c.execute("drop table militarytable")
c.execute("drop table petable")
c.execute("drop table realestatetable")
c.execute("drop table showbiztable")
c.execute("drop table technologytable")

con.commit()
con.close()
