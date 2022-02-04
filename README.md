# BrainEasy

## About

BrainEasy is a language that compiles to Brainfuck.
Take 2 arguments: **src** and **out**.

**src**

The source file.

**out**

The output file (Compiled).

> **Things to do**: <br> 
> Loops, <br>
> Conditions, <br>
> Mathemarical Operations <br>
> And more. <br>

---

## Testing

In the tests folder, has a Brainfuck interpreter and some sample files.

### Compiling the compiler

#### Windows

Run the `compile_and_run.bat` file.

#### Unix-Based Shells (Bash)

Maybe changing the extension to `.sh` and running can work.
(Not tested)

### Running the generated file

Go to **tests** folder and run the command:

`python interpeter.py <file> <true/false>`

The true/false argument is to tell the interpreter if it prints the char representaion of the cell or the
value itself.

**true** - prints the char representation of the cell's value
**false** - prints the number itself.

---

## Commands

> Note: You must use only one command per line!

```
print message / $cell
set value cell
input cell
moveptr left / right
setpointer position
ope cell +/-
move cellfrom cellto
```

## Examples

**Hello World**

`print Hello World`

---

**Printing an input value**

```
input 0
print $0
```

---

**Basic Adder**

```
input 0
input 1

move 0 2
move 1 2

print $2
```

# Have fun! :)
