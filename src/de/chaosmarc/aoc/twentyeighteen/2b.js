input = $("pre").innerHTML.split("\n").slice(0, -1);
for (i = 0; i < input.length; i++) {
    str = input[i];
    inner:
        for (j = 0; j < input.length; j++) {
            cmp = input[j];
            if (str != cmp) {
                diff = 0;
                diffpos = 0;
                for (c = 0; c < str.length; c++) {
                    if (str[c] != cmp[c]) {
                        diff++;
                        diffpos = c;
                    }
                    if (diff > 1) {
                        continue inner;
                    }
                }
                if (diff == 1) {
                    console.log("common letters: " + str.slice(0, diffpos) + str.slice(diffpos + 1))
                    break
                }
            }
        }
}