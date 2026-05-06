from pathlib import Path
p = Path('/Users/deeptibisht/Documents/digamber_workspace/java_generic_code_exercise/Java_Springboot_Microservices_Interview_QA.md')
content = p.read_text(encoding='utf-8-sig')
old = '# \U0001f393 Senior Java Tech Lead \u2014 Ultimate Interview Master Blueprint\n\n<div align="center">'
new = '<div align="center">\n\n# \U0001f393 Senior Java Tech Lead \u2014 Ultimate Interview Master Blueprint'
if old in content:
    content = content.replace(old, new)
    p.write_text(content, encoding='utf-8')
    print("Done - title moved inside center div")
else:
    print("Pattern not found")

