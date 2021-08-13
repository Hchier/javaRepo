# # import sqlite3
# # import xlrd
# # import xlwt
# #
# # con = sqlite3.connect('../lib_origin.db')
# # c = con.cursor()
# # excle1 = xlwt.Workbook(encoding = "utf-8")
# # sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)
# #
# # total_weight1 = 0
# # total_weight2 = 0
# # count = 0
# # count0 = 0
# # for i in range(0, 300):
# #     word1 = ''
# #     word2 = '0'
# #
# #     weight1 = 0
# #     weight2 = 0
# #
# #     sql1 = "select * from technologytable where seq='" + str(i) + "'"
# #     cursor = c.execute(sql1)
# #     for row in cursor:
# #         word1 = row[0]
# #         weight1 = row[1]
# #
# #     sql2 = "select * from financetable where keyword='" + word1 + "'"
# #     # print(sql2)
# #     cursor = c.execute(sql2)
# #     for row in cursor:
# #         word2 = row[0]
# #         weight2 = row[1]
# #
# #     if word2 == '0':
# #         count0 += 1
# #         multi = 2
# #     else:
# #         print("/:", weight1 / weight2)
# #         multi = weight1 / weight2
# #         if multi > 2:
# #             multi = 2
# #         if multi < 0.5:
# #             multi = 0.5
# #         print("multi:", multi)
# #
# #     if multi > 1:
# #         print()
# #         # delete_sql1 = "delete  from temptable where keyword='" + word1 + "'"
# #         # # print(select_sql1)
# #         # cursor1 = c.execute(delete_sql1)
# #     else:
# #
# #         print(word1, weight1, i + 1)
# #         select_sql1 = "select * from temptable where keyword='" + word1 + "'"
# #         # print(select_sql1)
# #         cursor1 = c.execute(select_sql1)
# #         temp_weight = 0
# #         for row1 in cursor1:
# #             print(row1[1])
# #             temp_weight = multi * float(row1[1])
# #
# #         update_sql1 = "update temptable set weight = " + str(temp_weight) + " where keyword ='" + word1 + "'"
# #         # update_sql2 = "update  temptable set seq = " + str(count) + " where keyword ='" + word1 + "'"
# #         print("update_sql:", update_sql1)
# #         # print("update_sq2:", update_sql2)
# #         cursor = c.execute(update_sql1)
# #         # cursor = c.execute(update_sql2)
# #         con.commit()
# #         total_weight1 += weight1
# #         count += 1
# # print("count:", count)
# # print("count0:", count0)
# # con.close()
#
#
#
# import sqlite3
# import xlrd
# import xlwt
#
# con = sqlite3.connect('../lib_origin.db')
# c = con.cursor()
# excle1 = xlwt.Workbook(encoding = "utf-8")
# sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)
#
# total_weight1 = 0
# total_weight2 = 0
# count = 0
# count0 = 0
# for i in range(0, 300):
#     word1 = ''
#     word2 = '0'
#
#     weight1 = 0
#     weight2 = 0
#
#     sql1 = "select * from financetable where seq='" + str(i) + "'"
#     cursor = c.execute(sql1)
#     for row in cursor:
#         word1 = row[0]
#         weight1 = row[1]
#
#     sql2 = "select * from technologytable where keyword='" + word1 + "'"
#     # print(sql2)
#     cursor = c.execute(sql2)
#     for row in cursor:
#         word2 = row[0]
#         weight2 = row[1]
#
#     if word2 == '0':
#         count0 += 1
#         multi = 1.3
#     else:
#         print("/:", weight1 / weight2)
#         multi = weight1 / weight2
#         if multi > 1.3:
#             multi = 1.3
#         if multi < 0.7:
#             multi = 0.7
#         print("multi:", multi)
#
#     if multi < 0:
#         print()
#         # delete_sql1 = "delete  from temptable where keyword='" + word1 + "'"
#         # # print(select_sql1)
#         # cursor1 = c.execute(delete_sql1)
#     else:
#
#         print(word1, weight1, i + 1)
#         select_sql1 = "select * from temptable where keyword='" + word1 + "'"
#         # print(select_sql1)
#         cursor1 = c.execute(select_sql1)
#         temp_weight = 0
#         for row1 in cursor1:
#             print(row1[1])
#             temp_weight = multi * float(row1[1])
#
#         update_sql1 = "update temptable set weight = " + str(temp_weight) + " where keyword ='" + word1 + "'"
#         # update_sql2 = "update  temptable set seq = " + str(count) + " where keyword ='" + word1 + "'"
#         print("update_sql:", update_sql1)
#         # print("update_sq2:", update_sql2)
#         cursor = c.execute(update_sql1)
#         # cursor = c.execute(update_sql2)
#         con.commit()
#         total_weight1 += weight1
#         count += 1
# print("count:", count)
# print("count0:", count0)
# con.close()


# import sqlite3
# import xlrd
# import xlwt
#
# con = sqlite3.connect('../lib_origin.db')
# c = con.cursor()
# excle1 = xlwt.Workbook(encoding = "utf-8")
# sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)
#
# total_weight1 = 0
# total_weight2 = 0
# count = 0
# count0 = 0
# for i in range(0, 300):
#     word1 = ''
#     word2 = '0'
#
#     weight1 = 0
#     weight2 = 0
#
#     sql1 = "select * from technologytable where seq='" + str(i) + "'"
#     cursor = c.execute(sql1)
#     for row in cursor:
#         word1 = row[0]
#         weight1 = row[1]
#
#     sql2 = "select * from financetable where keyword='" + word1 + "'"
#     # print(sql2)
#     cursor = c.execute(sql2)
#     for row in cursor:
#         word2 = row[0]
#         weight2 = row[1]
#
#     if word2 == '0':
#         count0 += 1
#         multi = 2
#     else:
#         print("/:", weight1 / weight2)
#         multi = weight1 / weight2
#         if multi > 2:
#             multi = 2
#         if multi < 0.5:
#             multi = 0.5
#         print("multi:", multi)
#
#     if multi > 1:
#         print()
#         # delete_sql1 = "delete  from temptable where keyword='" + word1 + "'"
#         # # print(select_sql1)
#         # cursor1 = c.execute(delete_sql1)
#     else:
#
#         print(word1, weight1, i + 1)
#         select_sql1 = "select * from temptable where keyword='" + word1 + "'"
#         # print(select_sql1)
#         cursor1 = c.execute(select_sql1)
#         temp_weight = 0
#         for row1 in cursor1:
#             print(row1[1])
#             temp_weight = multi * float(row1[1])
#
#         update_sql1 = "update temptable set weight = " + str(temp_weight) + " where keyword ='" + word1 + "'"
#         # update_sql2 = "update  temptable set seq = " + str(count) + " where keyword ='" + word1 + "'"
#         print("update_sql:", update_sql1)
#         # print("update_sq2:", update_sql2)
#         cursor = c.execute(update_sql1)
#         # cursor = c.execute(update_sql2)
#         con.commit()
#         total_weight1 += weight1
#         count += 1
# print("count:", count)
# print("count0:", count0)
# con.close()



import sqlite3
import xlrd
import xlwt

con = sqlite3.connect('../lib_origin.db')
c = con.cursor()
excle1 = xlwt.Workbook(encoding = "utf-8")
sheet1 = excle1.add_sheet("999", cell_overwrite_ok = True)

total_weight1 = 0
total_weight2 = 0
count = 0
count0 = 0
for i in range(0, 300):
    word1 = ''
    word2 = '0'

    weight1 = 0
    weight2 = 0

    sql1 = "select * from financetable where seq='" + str(i) + "'"
    cursor = c.execute(sql1)
    for row in cursor:
        word1 = row[0]
        weight1 = row[1]

    sql2 = "select * from technologytable where keyword='" + word1 + "'"
    # print(sql2)
    cursor = c.execute(sql2)
    for row in cursor:
        word2 = row[0]
        weight2 = row[1]

    # co-have
    if word2 != '0':
        print(word1, weight1, i + 1)
        select_sql1 = "select * from temptable where keyword='" + word1 + "'"
        # print(select_sql1)
        cursor1 = c.execute(select_sql1)
        temp_weight = 0
        for row1 in cursor1:
            print(row1[1])
            temp_weight = 0.3 * float(row1[1])

        update_sql1 = "update temptable set weight = " + str(temp_weight) + " where keyword ='" + word1 + "'"
        # update_sql2 = "update  temptable set seq = " + str(count) + " where keyword ='" + word1 + "'"
        print("update_sql:", update_sql1)
        # print("update_sq2:", update_sql2)
        cursor = c.execute(update_sql1)
        # cursor = c.execute(update_sql2)
        con.commit()
        total_weight1 += weight1
        count += 1
print("count:", count)
print("count0:", count0)
con.close()
