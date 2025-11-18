import time
import requests
from bs4 import BeautifulSoup

URL = "https://wise.dongguk.ac.kr/article/acdnotice/list"
CHECK_INTERVAL = 300  # 초 단위

def get_latest_post():
    resp = requests.get(URL)
    resp.raise_for_status()
    soup = BeautifulSoup(resp.text, "html.parser")
    # 실제로 제목과 날짜가 있는 요소 선택자 확인 필요
    row = soup.select_one("table tbody tr")  # 예시: 첫 행
    title = row.select_one("td.title a").get_text(strip=True)
    date = row.select_one("td.date").get_text(strip=True)
    return title, date

def send_notification(title, date):
    # 예: 텔레그램 봇 호출
    print(f"새 공지사항 발견: {title} ({date})")
    # 여기에 Telegram API 코드나 이메일 발송 코드 삽입

def main():
    last_title, last_date = get_latest_post()
    print(f"현재 최신 공지: {last_title} ({last_date})")
    while True:
        time.sleep(CHECK_INTERVAL)
        try:
            title, date = get_latest_post()
            if title != last_title:
                send_notification(title, date)
                last_title, last_date = title, date
        except Exception as e:
            print("오류 발생:", e)

if __name__ == "__main__":
    main()