import numpy as np
import pandas as pd

print("按索引")
pd1 = pd.DataFrame(np.arange(12).reshape(3, 4), columns=[2, 1, 0, 3])
print(pd1.sort_index(axis=1))
print()

print("按值 sort_value()")
