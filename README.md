# EasyExoPlayer

## SetUp
![Build Status](https://img.shields.io/badge/download-1.0.2-green.svg)

```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

```
dependencies {
      implementation 'com.github.chani01:EasyExoPlayer:1.0.2'
}
```

## How to use
### Player init
```
EasyExoPlayer.initPlayer(this, getString(your_app_name)
```

### SinglePlay
```
EasyExoPlayer.setDataSource(file_url)
EasyExoPlayer.play()
```

### PlayList
```
 val data = listOf(file_url1, file_url2, file_url3, file_url4)
 EasyExoPlayer.setPlayListSource(data)
 EasyExoPlayer.play()
```

## method
```
1. Play()
2. rePlay()
3. pause()
4. stop(resetStatus: Boolean) 
5. release()
6. isPlayer(): Boolean
7. isListSource(): Boolean
8. isDataSource(): Boolean
9. isPlaying(): Boolean
10.setAudioFocus(status : Boolean)
11.onListener - ExoPlayerListener
```

## License
```
Copyright 2020 chani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
