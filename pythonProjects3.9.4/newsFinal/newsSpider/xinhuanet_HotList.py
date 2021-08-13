import urllib.request
import urllib.error
import urllib.response
import re
import bs4


def ask_url(url):
    head = {
        "User-Agent": "Mozilla/5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 87.0.4280.88Safari / 537.36"
    }
    request = urllib.request.Request(url, headers = head)
    html = ""
    respond = urllib.request.urlopen(request)
    html = respond.read().decode("utf-8")
    # print(html)
    return html


findTitle = re.compile(r'<a href=.*">(.*)</a>')
findLink = re.compile(r'<a href="(.*)" target="_blank">')

def get_data_xinhuanet_hotlist():
    baseurl = "http://www.xinhuanet.com/"
    dataList = []
    html = ask_url(baseurl)
    bs = bs4.BeautifulSoup(html, 'html.parser')
    items = bs.find_all("div", class_="list")
    # print("items:", items)
    for item in items[0].find_all("a"):
        item = str(item)
        if item:
            if (re.findall(findLink, item) != []) and (re.findall(findTitle, item) != []):
                link = re.findall(findLink, item)[0]  # 若有多个取1st，否则返回字符组
                title = re.findall(findTitle, item)[0]
                dataList.append(title)
                dataList.append(link)
    return dataList


def save_data(list):
    for item in list:
        print(item)


def start():
    save_data(get_data_xinhuanet_hotlist())


if __name__ == "__main__":
    start()
