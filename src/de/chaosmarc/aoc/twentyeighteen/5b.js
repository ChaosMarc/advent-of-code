input = $("pre").innerHTML.split("\n").slice(0, -1)[0];
letters = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];
min = input.length;
for (i = 0; i < letters.length; i++) {
    cur = input;
    str = letters[i] + "|" + letters[i].toUpperCase();
    var re = new RegExp(str, "g");
    cur = cur.replace(re, "");
    inner:
        while (true) {
            prev = cur.length;
            cur = cur.replace(/aA|Aa|bB|Bb|cC|Cc|dD|Dd|eE|Ee|fF|Ff|gG|Gg|hH|Hh|iI|Ii|jJ|Jj|kK|Kk|lL|Ll|mM|Mm|nN|Nn|oO|Oo|pP|Pp|qQ|Qq|rR|Rr|sS|Ss|tT|Tt|uU|Uu|vV|Vv|wW|Ww|xX|Xx|yY|Yy|zZ|Zz/g, '');
            if (cur.length < min) {
                min = cur.length;
            }
            if (prev == cur.length) {
                break;
            }
        }
}
console.log(min);