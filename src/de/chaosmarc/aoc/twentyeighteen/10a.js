input = $("pre").innerHTML.split("\n").slice(0, -1);
seconds = 150;
str = "";
for (i = 0; i < input.length; i++) {
    tmp = input[i].split("&gt; velocity=&lt;");
    coords = tmp[0].slice(13).split(", ").map(s => parseInt(s));
    velocity = tmp[1].slice(0, 6).split(", ").map(s => parseInt(s));
    str += (coords[0] + (velocity[0] * seconds)) + "\t" + (coords[1] + (velocity[1] * seconds)) + "\n";
}

var dummy = document.createElement("textarea");
document.body.appendChild(dummy);
dummy.setAttribute("id", "dummy_id");
document.getElementById("dummy_id").value = str;
dummy.select();
document.execCommand("copy");
//document.body.removeChild(dummy);