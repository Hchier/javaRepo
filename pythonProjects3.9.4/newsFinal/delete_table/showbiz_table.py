import sqlite3

con = sqlite3.connect('../test.db')
c = con.cursor()


c.execute("delete from showbiztable")


# cursor = c.execute("select * from educationtable")
# print("cursor:", cursor)
# for row in cursor:
#     print(row[0], row[1])

con.commit()
con.close()