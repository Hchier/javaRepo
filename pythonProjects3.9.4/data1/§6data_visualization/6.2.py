import matplotlib.pyplot as plt
import numpy as np
import pandas as pd


data1 = pd.read_excel('E:\Hchier\A\华清远见\data\player.xlsx')['weight']
print(data1)
plt.hist(data1)
plt.show()