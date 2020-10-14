# Encryption-Decryption-Script
A java script which encrypted or decrypted a txt file or a simple string via console using the Strategy pattern.

After compiling you have to specify some values as:

`-mode`, enc for encryption and dec for decryption

`-key`, working on the respective encryption/decrytion mode, this is how many spaces letters going to change positions


`-data`, put a string to encode/decode

`-in`, you can upload the string to work with in a txt file with its path dir

`-alg`, there are two, shift and unicode

`-out`, you can also save the resulting string in a txt file, if there is not out statement, the result will be print it in the console

For example:

-`java Main -mode enc -key 5 -data "Hello World"`

-`java Main -mode dec -key 15 -in "...\\word.txt" -alg unicode -out "..\\word_result.txt"`
