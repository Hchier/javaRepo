import sqlite3

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()


c.execute("delete from  temptable")


# cursor = c.execute("select * from educationtable")
# print("cursor:", cursor)
# for row in cursor:
#     print(row[0], row[1])

con.commit()
con.close()