import xlrd
import xlwt
import jieba.posseg
from collections import Counter

excle_result = xlwt.Workbook(encoding="utf-8")
book = xlrd.open_workbook(r'E:\Hchier\pythonProjects3.9.4\newsFinal\test_data.xlsx')
# book = xlrd.open_workbook(r'E:\Desktop\333.xlsx')
list_sheet_names = book.sheet_names()
for i_total in range(0, len(list_sheet_names)):
    sheet = book.sheet_by_name(list_sheet_names[i_total])
    sheet_result = excle_result.add_sheet(list_sheet_names[i_total], cell_overwrite_ok=True)
    str1 = ''
    for j in range(0, sheet.nrows):
        if sheet.cell_value(rowx=j, colx=0):
            str1 = str1 + sheet.cell_value(rowx=j, colx=0)
    items = []
    items_all = jieba.posseg.cut(str1)
    for item in items_all:
        if (item.flag == 'n' or
            item.flag == 'nr' or item.flag == 'ns' or
            item.flag == 'nt' or item.flag == 'nz') and len(item.word) > 1:
            items.append(item.word)
    i1 = 0
    for c in Counter(items).most_common(300):
        for j in range(0, 2):
            sheet_result.write(i1, j+3, c[j])
        i1 += 1
    i1 = 0
    for c in Counter(items).most_common(50):
        for j in range(0, 2):
            sheet_result.write(i1, j+15, c[j])
        i1 += 1
print(list_sheet_names)
excle_result.save(r'E:\Desktop\weight.xls')
