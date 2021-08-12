#import <React/RCTBridgeDelegate.h>
#import <UIKit/UIKit.h>
#import "GetIDExample-Swift.h"

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>

@property (nonatomic, strong) UIWindow *window;
@property (nonatomic, strong) GetIDSwiftWrapper *getIDWrapper;
@end
