import sys

def compile(src, out):
    lines = src.readlines()
    
    for line in lines:
        split = line.split(' ', 1)
        command = split[0]
        
        #if command == 'print':
            

if __name__ == '__main__':
    try:
        src = None
        out = None
        
        with open(sys.argv[0], 'r') as src_file:
            src = src_file
        
        out = sys.argv[1]
        
        compile(src, out)
    except Exception as e:
         print("Cannot read file. Compilation terminated.")
