import urllib.request
import urllib.error
import urllib.response
import re
import bs4


def ask_url(url):
    head = {
        "User-Agent": "Mozilla/5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 87.0.4280.88Safari / 537.36"
    }
    # head = {
    #     ""
    # }
    request = urllib.request.Request(url, headers=head)
    html = ""
    respond = urllib.request.urlopen(request)
    html = respond.read().decode("utf-8")
    # print(html)
    return html


def start():
    url = "http://dev.hzero.org:8080/oauth/login"
    print(ask_url(url))


if __name__ == "__main__":
    start()
