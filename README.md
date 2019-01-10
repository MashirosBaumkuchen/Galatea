### Galatea project

#### base

* kotlin
* apply MVVM, liveData& ViewModel
* rxjava+retrofit+okhttp
* glide 
* material design
* aidl
* remoteView
* custom view
* etc

#### display
<div>
  
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/splash.png" width="201" height="358" />
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/recommend.png" width="201" height="358" />
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/playlist.png" width="201" height="358" />

</div>



<div>
  
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/songs.png" width="201" height="358" />
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/player.png" width="201" height="358" />
  <img src="https://github.com/MashirosBaumkuchen/Galatea/blob/master/pic/profile.png" width="201" height="358" />

</div>

#### liveData+viewModel

why?
because mvp could cause a memory leak problem, for example

```
class MyPresenter{
    var mView ?= null
        set(view:MyView) = view
    ...
}

class MyView{
    val mPresenter = MyPresenter()

    override fun onCreate(){
        ...
        mPresenter.mView = this
    }
    ...
}
```

and mvvm separate view from model proxy

* compare to MVP: reduce callback in {presenter->view}

#### api

~~ready to change api~~

~~rank list~~
~~https://api.apiopen.top/musicRankings~~

~~rank detail~~
~~https://api.apiopen.top/musicRankingsDetails?type=1~~

~~song~~
~~https://api.apiopen.top/musicDetails?id=610722309~~

API from [NeteaseCloudMusicApi](https://github.com/Binaryify/NeteaseCloudMusicApi), 
the API backend system now is just running on localhost

#### application structure

```
GalateaApplication{
    DisplayService{
    // based on binder, offer display function, process:player
        displayList getter&setter
        play
        pause
        model setter
    }

    SplashActivity{
        // TODO
    }

    MainActivity{
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> RecodeActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[search], position=[right&top], widget=[button]
        >> SearchActivity

        // describe=[playing page], position=[right&top], widget=[button with lottie animation]
        >> DisplayActivity

        // describe=[tab], position=[bottom], widget=[tab with anim line]

        DiscoverFragment{
        // songs form remote, api request, based on api
            // describe=[multiRecyclerView, with refresh], position=[fill], widget=[item view group]
                // describe=[song list item], position=[], widget=[index, songTitle, artist, duration etc]
                >> DisplayActivity
        }

        ListFragment{
        // there are three basic list, [favorite], [recently], [newest], and custom list
            // describe=[multiRecyclerView], position=[wrap], widget=[item view group]{
                // describe=[album list item], position=[], widget=[icon, albumTitle]
                >> AlbumActivity
            }
            // describe=[create new album], position=[under list], widget=[same with item]
            >> AlbumActivity
        }

        ProfileFragment{
        // personal information show, player setting
            // describe=[information bar], position=[top], widget=[view group]
            >> SettingProfileActivity

            // describe=[setting list], position=[wrap], widget=[multiRecyclerView]
                // describe=[item of setting label], position=[], widget=[text+button]
        }
    }

    RecordActivity{
        // describe=[back button], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[record button], position=[center], widget=[custom button]
    }

    SearchActivity{
        // describe=[back button], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[search editor], position=[center&top], widget=[text]

        // describe=[result list], position=[fill], widget=[RecyclerView]
    }

    DisplayActivity{
    // function based on ipc, music play in media process
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[display card], position=[center], widget=[cardView, with display function]
            // describe=[bg], position=[], widget=[image]
            // describe=[turn previous], position=[], widget=[button with icon]
            // describe=[play or pause], position=[], widget=[button with icon]
            // describe=[turn next], position=[], widget=[button with icon]
            // describe=[play model, such as single_cycle, album_cycle, random_cycle], position=[], widget=[button with icon]
            // describe=[show play list], position=[], widget=[button with icon]
    }

    AlbumActivity{
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[display card], position=[center], widget=[cardView, with display function]
            // describe=[bg], position=[], widget=[image]
            // describe=[album title], position=[], widget=[text, can be edit]
            // describe=[album describe], position=[], widget=[text, can be edit]
            // describe=[album bg chooser], position=[], widget=[button]

        // describe=[album list], position=[fill], widget=[recyclerView]
            // describe=[song list item], position=[], widget=[index, songTitle, artist, duration etc]
    }

    SettingProfileActivity{
        // TODO
    }

    DonateActivity{
        // TODO
    }

    RemoteView{
        // TODO
    }

    NoticeView{
        // TODO
    }
}
```

#### package state

* notice: lazy initial

package: com.jascal.galatea

|-base
    |-I
|-cache
|-mvvm
    |-main
    |-about
    |-album
    |-display
    |-record
    |-search
    |-setting
    |-splash
|-net
|-permission
|-service
|-utils
|-widget


#### todo list

* music play, 
* generator key method, md5
* viewPagerAdapter destroy item method, apply lazy load fragment
