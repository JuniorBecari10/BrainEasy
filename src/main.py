import sys

def compile(src, out):
    lines = src.readlines()
    print(lines[0])
    for line in lines:
        split = line.split(' ', 1)
        command = split[0]
        
        if command == 'print':
            print("Print")

if __name__ == '__main__':
    try:
        src = open(sys.argv[0], 'r')
        out = sys.argv[1]
        
        compile(src, out)
    except Exception as e:
         print("Cannot read file. Compilation terminated.")
