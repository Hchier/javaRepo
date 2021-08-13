import xlrd
# import xlwt
import jieba.posseg
import sqlite3


# from collections import Counter
# from nltk.cluster.util import cosine_distance
# import numpy

def get_table_name(name):
    if name == '汽车':
        return "cartable"
    elif name == '教育':
        return "educationtable"
    elif name == '财经':
        return "financetable"
    elif name == '游戏':
        return "gametable"
    elif name == '军事':
        return "militarytable"
    elif name == '体育':
        return "petable"
    elif name == '房产':
        return "realestatetable"
    elif name == '娱乐':
        return "showbiztable"
    elif name == '科技':
        return "technologytable"


def second_compare_def(words, name):
    con = sqlite3.connect('../test_second.db')
    c = con.cursor()
    second_weight = 0
    for word in words:
        select_sql = "select * from " + get_table_name(name) + " where keyword='" + word + "'"
        # print(select_sql)
        cursor = c.execute(select_sql)
        # print("cursor:", cursor)
        for row in cursor:
            # print(row[0])
            second_weight += row[1]

    return second_weight
