# Ansible script samples


## `local_action` with `sudo`

`local_action`과 `sudo`/`become`를 함께 사용할 때 발생하는 문제 샘플

related to: [[Ansible] sudo/become과 함께 local_action 실행 시 문제](http://blog.leocat.kr/notes/2018/09/10/ansible-localaction-with-sudo)

how to run:

```bash
$ ansible-playbook -i inventories/dev test-local-action.yaml
```

