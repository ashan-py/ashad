import random

def generate_ladder(n_rows, n_people):
    ladder = [[' ' for _ in range(n_people)] for _ in range(n_rows)]
    for row in ladder:
        for i in range(n_people - 1):
            if random.choice([True, False]):
                row[i] = '-'
                row[i+1] = '-'
    return ladder

def print_ladder(ladder, names):
    n_people = len(names)
    for row in ladder:
        line = ''
        for i in range(n_people):
            line += '|'
            if row[i] == '-':
                line += '---'
            else:
                line += '   '
        print(line)

def run_ladder(ladder, start_index):
    pos = start_index
    for row in ladder:
        if pos > 0 and row[pos - 1] == '-':
            pos -= 1
        elif pos < len(row) - 1 and row[pos] == '-':
            pos += 1
    return pos

def main():
    names = input("이름을 공백으로 구분해 입력하세요: ").split()
    results = input("결과 리스트를 공백으로 입력하세요 (ex. 당첨 꽝 꽝): ").split()

    n_people = len(names)
    n_rows = 5  # 사다리 높이

    ladder = generate_ladder(n_rows, n_people)

    print("\n------ 사다리 ------")
    print_ladder(ladder, names)

    print("\n------ 결과 ------")
    for idx, name in enumerate(names):
        final_index = run_ladder(ladder, idx)
        print(f"{name} → {results[final_index]}")

if __name__ == "__main__":
    main()