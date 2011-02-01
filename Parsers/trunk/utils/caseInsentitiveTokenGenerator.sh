#!/usr/bin/awk -f
{
  printf("%s : ", toupper($0));
  for (i = 1; i <= length($0); i++) {
    c = substr($0, i, 1);
    if (toupper(c) != tolower(c))
      printf("('%s'|'%s')", toupper(c), tolower(c));
    else
      printf("('%s')", c);
  }
  print " ;";
}