import urllib.request
import urllib.error
import urllib.response
import re
import bs4
import time



def ask_url(url):
    head = {
        "User-Agent": "Mozilla/5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 87.0.4280.88Safari / 537.36"
    }
    request = urllib.request.Request(url, headers=head)
    html = ""
    respond = urllib.request.urlopen(request)
    html = respond.read().decode("utf-8")
    # print(html)
    return html


findLink = re.compile(r'<a href="(.*)">')
findTitle = re.compile(r'<a href=.*">(.*)</a>')


def get_data_peopledaily_hotlist():
    localtime = time.localtime(time.time())
    year = str(localtime.tm_year)
    mon = localtime.tm_mon
    day = localtime.tm_mday
    if localtime.tm_mon < 10:
        mon = str(0) + str(localtime.tm_mon)
    if localtime.tm_mday < 10:
        day = str(0) + str(localtime.tm_mday)
    baseurl = "http://paper.people.com.cn/rmrb/html/" + str(year) + "-" + str(mon) + "/" + str(
        day) + "/nbs.D110000renmrb_01.htm"

    dataList = []
    html = ask_url(baseurl)
    bs = bs4.BeautifulSoup(html, 'html.parser')
    items = bs.find_all("ul", class_="news-list")
    for item in items[0].find_all("li"):
        item = str(item)
        if item:
            if (re.findall(findLink, item) != []) and (re.findall(findTitle, item) != []):
                link = re.findall(findLink, item)[0]  # 若有多个取1st，否则返回字符组
                link = "http://paper.people.com.cn/rmrb/html/" + str(year) + "-" + str(mon) + "/" + str(
                    day) + "/" + link
                title = re.findall(findTitle, item)[0]
                dataList.append(title)
                dataList.append(link)
    return dataList


def save_data(list):
    for item in list:
        print(item)


def start():
    save_data(get_data_peopledaily_hotlist())


if __name__ == "__main__":
    start()
