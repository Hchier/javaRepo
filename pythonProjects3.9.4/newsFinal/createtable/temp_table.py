import sqlite3

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()

c.execute('''CREATE TABLE temptable
       (keyword CHAR(10) PRIMARY KEY NOT NULL,
       weight real not null,
       seq integer not null 
       );''')

con.commit()
con.close()
