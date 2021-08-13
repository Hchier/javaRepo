import sqlite3

con = sqlite3.connect('../test.db')
c = con.cursor()

c.execute('''CREATE TABLE financetable
       (keyword CHAR(10) PRIMARY KEY NOT NULL,
       weight real not null
       );''')

con.commit()
con.close()
