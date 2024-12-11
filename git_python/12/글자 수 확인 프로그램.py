def get_multiline_input():
    print("본문을 입력하세요 (빈 줄 입력 시 종료):")
    lines = []
    while True:
        line = input()  # 각 줄을 입력받음
        if line == "":  # 빈 줄이면 입력 종료
            break
        lines.append(line)
    return "\n".join(lines)  # 줄바꿈을 포함한 텍스트 반환

# 여러 줄 입력 받기
text = get_multiline_input()

# 입력된 텍스트에서 공백 제거 및 글자 수 계산
num = len(text)  # 공백 포함한 전체 글자 수
ntext = text.replace(" ", "")  # 공백 제거한 텍스트
nb = len(ntext)  # 공백 제외한 글자 수

# 결과 출력
print("\n입력된 텍스트:")
print(text)
print("공백 포함 : " + str(num) + "\n공백 제외: " + str(nb))