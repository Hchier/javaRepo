import sqlite3

con = sqlite3.connect('../lib30_second.db')
c = con.cursor()

c.execute('''CREATE TABLE cartable
       (keyword CHAR(10) NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE educationtable
       (keyword CHAR(10) NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE financetable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE gametable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE militarytable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE petable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE realestatetable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE showbiztable
       (keyword CHAR(10)  NOT NULL,
       weight real not null,
       seq integer not null 
       );''')
c.execute('''CREATE TABLE technologytable
       (keyword CHAR(10) NOT NULL,
       weight real not null,
       seq integer not null 
       );''')

con.commit()
con.close()
