import tkinter as tk

window = tk.Tk()
window.title('win')
window.geometry('700x250')
entry = tk.Entry(window)
entry.pack()
var = tk.StringVar()
var_rb = tk.StringVar()
label = tk.Label(window, text = 'hi', bg = 'blue', width = 15, height = 2)
label.pack()
text1 = tk.Text(window, width = 15, height = 2)
text1.pack()


def insert_point():
    var = entry.get()
    text1.insert('insert', var)


def insert_end():
    var = entry.get()
    text1.insert('end', var)


def print_selection():
    label.config(text = 'you select' + var_rb.get())


button1 = tk.Button(window, text = 'insert_point', width = 15, height = 2,
                    command = insert_point)
button1.pack()
button2 = tk.Button(window, text = 'insert_end', width = 15, height = 2,
                    command = insert_end)
button2.pack()

radiobutton1 = tk.Radiobutton(window, text = 'A', variable = var_rb, value = 'a',
                              command = print_selection)
radiobutton1.pack()
radiobutton2 = tk.Radiobutton(window,
                              text = 'B', variable = var_rb, value = 'B',
                              command = print_selection)
radiobutton2.pack()

text2 = tk.Text(window, width = 15, height = 2)
text2.pack()

window.mainloop()
