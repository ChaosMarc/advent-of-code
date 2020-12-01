input = $("pre").innerHTML.split("\n").slice(0, -1);

twice = 0;
thrice = 0;
for (i = 0; i < input.length; i++) {
    str = input[i].split("").sort().join("");
    count = 1;
    twicefound = false;
    thricefound = false;
    for (c = 0; c < str.length; c++) {
        if (str[c] == str[c + 1]) {
            count++;
        } else {
            if (!twicefound && count == 2) {
                twice++;
                twicefound = true;
            } else if (!thricefound && count == 3) {
                thrice++;
                thricefound = true;
            }
            count = 1;
        }
    }
    console.log(str + ": twice=" + twice + ", thrice=" + thrice);
}
console.log("Checksum: " + twice + " * " + thrice + " = " + twice * thrice);