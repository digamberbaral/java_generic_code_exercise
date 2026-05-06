from pathlib import Path

p = Path('/Users/deeptibisht/Documents/digamber_workspace/java_generic_code_exercise/Java_Springboot_Microservices_Interview_QA.md')
content = p.read_bytes().decode('utf-8-sig')
lines = content.split('\n')

print(f"Total lines: {len(lines)}")
print("First 12 lines:")
for i in range(min(12, len(lines))):
    print(f"  {i+1}: {repr(lines[i][:130])}")

# Fix: find line with 'React Core Theory' stray text
fixed = False
for i, line in enumerate(lines):
    if 'React Core Theory' in line and 'redis' in line.lower():
        print(f"\nFOUND problematic line at {i+1}")
        # Keep only up to and including the closing paren of the badge
        idx = line.find('logo=redis)')
        if idx >= 0:
            lines[i] = line[:idx + len('logo=redis)')]
        else:
            # Alternative: just remove the stray text
            lines[i] = line.replace('React Core Theory \u2014 Step-by-Step Foundation', '').replace('React Core Theory — Step-by-Step Foundation', '')
        print(f"  Fixed to: {repr(lines[i][:130])}")
        fixed = True
        break

if fixed:
    p.write_text('\n'.join(lines), encoding='utf-8')
    print("\n✅ File saved!")
else:
    print("\nNo problematic line found - checking for other issues...")
    for i in range(min(12, len(lines))):
        if 'React' in lines[i]:
            print(f"  Line {i+1} has 'React': {repr(lines[i][:130])}")

