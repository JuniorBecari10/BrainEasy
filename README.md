# BrainEasy

## About

BrainEasy is a language that compiles to Brainfuck.
Take 2 arguments: **src** and **out**.

**src**

The source file.

**out**

The output file (Compiled).

> It doesn't emulate yet: <br> 
> Loops, <br>
> Conditions, <br>
> And more. <br>

**Maybe I can modify this project later.**

--------------------------

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

`python interpeter.py <file>`

--------------------------

## Commands

> Note: You must use only one command per line!

**print** message / $cell
**set** value cell
**input** cell
**moveptr** left / right
**setpointer** position

## Example

**Hello World**

`print Hello World`

---------------

**Printing an input value**

```
input 0
print $0
```

# Have fun! :)
