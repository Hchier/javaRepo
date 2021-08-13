from flask import Flask

app = Flask(__name__)


# 首页
@app.route('/')  # 接口地址
def index():
    # 接口本身
    return 'home'


# 登录页
@app.route('/login')  # 接口地址
def login():
    # 接口本身
    return 'login sucess'


@app.route('/test.html')  # 接口地址
def test():
    # 接口本身
    return 'test'

# web 服务器
if __name__ == '__main__':
    app.run()

