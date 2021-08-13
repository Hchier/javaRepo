import sqlite3

con = sqlite3.connect('../test_origin.db')
c = con.cursor()

select_sql = "select * from temptable where seq = 1"
print(select_sql)
cursor = c.execute(select_sql)

for row in cursor:
    print(row[0])

