import xlwt

excle = xlwt.Workbook(encoding="utf-8")
# sheet1 = excle.add_sheet("财经", cell_overwrite_ok=True)
# row = 0
# for i in range(824946, 836075): # 836075
#     path = 'E:\Hchier\THUCNews\财经' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet1.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
# sheet2 = excle.add_sheet("科技", cell_overwrite_ok=True)
# row = 0
# for i in range(595700, 644578): # 644578
#     path = 'E:\Hchier\THUCNews\科技' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet2.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
# sheet3 = excle.add_sheet("房产", cell_overwrite_ok=True)
# row = 0
# for i in range(278445, 284460): # 284460
#     path = 'E:\Hchier\THUCNews\房产' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet3.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
# sheet4 = excle.add_sheet("教育", cell_overwrite_ok=True)
# row = 0
# for i in range(313815, 326396): # 326396
#     path = 'E:\Hchier\THUCNews\教育' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet4.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
# sheet5 = excle.add_sheet("体育", cell_overwrite_ok=True)
# row = 0
# for i in range(105282, 131603): # 131603  0.8
#     path = 'E:\Hchier\THUCNews\体育' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet5.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
#
# sheet7 = excle.add_sheet("娱乐", cell_overwrite_ok=True)
# row = 0
# for i in range(205709, 224235):  # 224235   0.8
#     path = 'E:\Hchier\THUCNews\娱乐' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet7.write(row, 0, file1.read())
#     row += 1
#     print(i)
#     print((i - 798977) / (836075 - 798977) * 100)
# excle.save(r"E:\Desktop\THUCNews.xls")
#
sheet8 = excle.add_sheet("军事", cell_overwrite_ok=True)
row = 0
for i in range(339764, 340040):  # 340040   0.8
    # path = 'E:' + '\\' + 'Hchier' + '\\' + 'THUCNews\军事' + '\\' + str(i) + '.txt'
    str3 = '\\'
    print(str3)
    path = r'E:/Hchier/THUCNews/时政' + '/' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    sheet8.write(row, 0, file1.read())
    row += 1
    print(i)
    print((i - 798977) / (836075 - 798977) * 100)
excle.save(r"E:\Desktop\THUCNews1.xls")

# sheet6 = excle.add_sheet("游戏", cell_overwrite_ok=True)
# row = 0
# for i in range(427435, 430801):  # 430801   0.8
#     path = 'E:\Hchier\THUCNews\游戏' + '\\' + str(i) + '.txt'
#     file1 = open(path, 'r', encoding='UTF-8')
#     sheet6.write(row, 0, file1.read())
#     excle.save(r"E:\Desktop\THUCNews1.xls")
#     row += 1
#     print(row)

# excle.save(r"E:\Desktop\THUCNews1.xls")
