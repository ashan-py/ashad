def factorial(n):
    if n == 0 or n == 1:
        return 1  # 기본 종료 조건 (Base case)
    else:
        return n * factorial(n - 1)  # 재귀 호출

# 예시 실행
num = int(input("숫자 입력: "))
print(factorial(num))  # 출력: 120