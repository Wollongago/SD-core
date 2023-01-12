# Software Design Project Core Repo
**We're going to use `SpringBoot` in this repo, details TBC**

## Sync and test on server
Add the host `lonnstyle-linux` to your host file:<br/>
**MacOS**:
> ```
> # /etc/hosts
> Host fyp
>   HostName 223.18.49.174
>   User fyp
> ```
Execute `sync-to.sh` to sync all the local files to the host server

**Windows**:
> ```
> #C:\Users\UserName\.ssh
> Host fyp
>   HostName 223.18.49.174
>   User fyp
> ```

Install `WSL(Windows Subsystem Linux)` on your PC<br/>
The file path will be `/mnt/<Disk initial>/<file path on windows>`<br/>
Execute `sync-to.sh` in the `WSL`

### Test
Open your `terminal`/`cmd`
> ```cmd
> ssh fyp
> cd /home/fyp/SD-core/core/
> make build
> make up
> ```

Open the site with this [link](http://223.18.49.174:8000)