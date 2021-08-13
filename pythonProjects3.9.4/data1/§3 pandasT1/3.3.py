import numpy as np
import pandas as pd

print("pandas算数运算时，先对齐")
pd1 = pd.Series([3, 4, 5, 6])
pd2 = pd.Series([1, 2, 3])
print("空的用NaN填充")
print(pd1 + pd2)
print("指定空的用0填充")
print(pd1.add(pd2, fill_value=0))
print()

pd3 = pd.DataFrame(np.arange(12).reshape(3, 4), columns=['a', 'b', 'c', 'd'])
pd4 = pd.DataFrame(np.arange(8).reshape(2, 4), columns=['a', 'b', 'c', 'd'])
print(pd3)
print(pd4)
print(pd3 + pd4)
print(pd3.add(pd4, fill_value=0))
